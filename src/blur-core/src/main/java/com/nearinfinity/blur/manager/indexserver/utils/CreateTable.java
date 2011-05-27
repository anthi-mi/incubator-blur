/*
 * Copyright (C) 2011 Near Infinity Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nearinfinity.blur.manager.indexserver.utils;

import static com.nearinfinity.blur.utils.BlurConstants.SHARD_PREFIX;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.zookeeper.ZooKeeper;

import com.nearinfinity.blur.BlurShardName;
import com.nearinfinity.blur.analysis.BlurAnalyzer;
import com.nearinfinity.blur.log.Log;
import com.nearinfinity.blur.log.LogFactory;
import com.nearinfinity.blur.manager.indexserver.DistributedManager;
import com.nearinfinity.blur.manager.indexserver.ZookeeperDistributedManager;
import com.nearinfinity.blur.manager.indexserver.ZookeeperPathConstants;
import com.nearinfinity.blur.zookeeper.ZkUtils;

public class CreateTable {
    
    private static Log LOG = LogFactory.getLog(CreateTable.class);

    public static void main(String[] args) throws IOException {
        String zkConnectionStr = args[0];
        String table = args[1];
        BlurAnalyzer analyzer = BlurAnalyzer.create(new File(args[2]));
        String uri = args[3];
        String shardCount = args[4];

        ZooKeeper zooKeeper = ZkUtils.newZooKeeper(zkConnectionStr);
        ZookeeperDistributedManager dm = new ZookeeperDistributedManager();
        dm.setZooKeeper(zooKeeper);
        if (dm.exists(ZookeeperPathConstants.getBlurTables(), table)) {
            System.err.println("Table [" + table + "] already exists.");
            System.exit(1);
        }
        createTable(dm,table,analyzer,uri,shardCount);
    }
    
    public static void createTable(DistributedManager dm, String table, BlurAnalyzer analyzer, String uri, String shardCount) throws IOException {
        setupFileSystem(uri,Integer.parseInt(shardCount));
        dm.createPath(ZookeeperPathConstants.getBlurTables(), table);
        dm.createPath(ZookeeperPathConstants.getBlurTables(), table, ZookeeperPathConstants.getBlurTablesUri());
        dm.createPath(ZookeeperPathConstants.getBlurTables(), table, ZookeeperPathConstants.getBlurTablesShardCount());
        dm.saveData(analyzer.toString().getBytes(), ZookeeperPathConstants.getBlurTables(), table);
        dm.saveData(uri.getBytes(), ZookeeperPathConstants.getBlurTables(), ZookeeperPathConstants.getBlurTablesUri());
        dm.saveData(shardCount.getBytes(), ZookeeperPathConstants.getBlurTables(), ZookeeperPathConstants.getBlurTablesShardCount());
    }

    private static void setupFileSystem(String uri, int shardCount) throws IOException {
        Path tablePath = new Path(uri);
        FileSystem fileSystem = FileSystem.get(tablePath.toUri(), new Configuration());
        createPath(fileSystem,tablePath);
        for (int i = 0; i < shardCount; i++) {
            String shardName = BlurShardName.getShardName(SHARD_PREFIX, i);
            Path shardPath = new Path(tablePath, shardName);
            createPath(fileSystem, shardPath);
        }
    }

    private static void createPath(FileSystem fileSystem, Path path) throws IOException {
        if (!fileSystem.exists(path)) {
            LOG.info("Path [{0}] does not exist, creating.",path);
            fileSystem.mkdirs(path);
        }
    }

}
