/*
 * Copyright 2013 Adam Dubiel, Przemek Hertel.
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
package org.polyjdbc.core.integration;

import org.polyjdbc.core.query.QueryFactory;
import org.polyjdbc.core.query.QueryRunner;
import org.polyjdbc.core.query.QueryRunnerFactory;

/**
 *
 * @author Adam Dubiel
 */
public class TheCleaner {

    private QueryRunnerFactory queryRunnerFactory;

    public TheCleaner(QueryRunnerFactory queryRunnerFactory) {
        this.queryRunnerFactory = queryRunnerFactory;
    }

    public void cleanDB(String... tables) {
        QueryRunner runner = queryRunnerFactory.create();

        for (String table : tables) {
            runner.delete(QueryFactory.delete().from(table));
        }

        runner.close();
    }
}
