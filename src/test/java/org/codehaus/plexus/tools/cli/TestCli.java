package org.codehaus.plexus.tools.cli;

/*
 * Copyright 2006 The Codehaus Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.util.FileUtils;

/**
 * @author Jason van Zyl
 */
public class TestCli extends AbstractCli {
    public static void main(String[] args) throws Exception {
        new TestCli().execute(args);
    }

    public Options buildCliOptions(Options options) {
        options.addOption(OptionBuilder.withLongOpt("name")
                .withDescription("Display name.")
                .hasArg()
                .create('n'));

        return options;
    }

    public void invokePlexusComponent(CommandLine cli, PlexusContainer container) throws Exception {
        if (cli.hasOption('n')) {
            String directory = cli.getOptionValue('n');

            FileUtils.mkdir(new File(directory, "target").getAbsolutePath());

            FileUtils.fileWrite(new File(directory, "target/cli.txt").getAbsolutePath(), "NAME_OPTION_INVOKED");
        }
    }
}
