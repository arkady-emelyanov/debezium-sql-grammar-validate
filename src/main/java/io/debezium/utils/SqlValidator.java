package io.debezium.utils;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import io.debezium.connector.mysql.antlr.MySqlAntlrDdlParser;
import io.debezium.relational.Tables;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class SqlValidator {
    private static final Logger logger = LoggerFactory.getLogger(SqlValidator.class);

    public static void main(String[] args) throws ArgumentParserException, IOException {
        ArgumentParser parser = ArgumentParsers
                .newFor("Debezium MySQL parser")
                .build()
                .defaultHelp(true)
                .description("Debezium MySQL parser");

        parser.addArgument("-f", "--file")
                .type(String.class)
                .required(true)
                .help("Read SQL commands from file");

        final Namespace args1 = parser.parseArgs(args);
        String fileName = args1.getString("file");
        logger.info("Reading {}", fileName);

        File file = new File(fileName);
        String ddlContent = FileUtils.readFileToString(file, "utf-8");
        logger.info("Provided SQL: '{}'", ddlContent);

        MySqlAntlrDdlParser sqlParser = new MySqlAntlrDdlParser();
        Tables tables = new Tables();
        sqlParser.parse(ddlContent, tables);

        logger.info("Parse successful.");
    }
}
