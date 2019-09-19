package controllers;

import akka.util.ByteString;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.Config;
import hive.metastore.HiveMetastoreImpl;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;
import play.Logger;
import play.Play;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import security.AuthUtil;
import security.AuthenticationManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.stream.Stream;

public class MetastoreApplication extends Controller {

    private final Config _config;
    private static HiveMetastoreImpl handler;

    private static ThriftHiveMetastore.Processor processor;
//    private final ThriftHiveMetastore.Client metastoreThriftClient;


    @Inject
    public MetastoreApplication(@Nonnull Config config) throws IOException {
      _config = config;
        handler = new HiveMetastoreImpl();
        processor = new ThriftHiveMetastore.Processor(handler);
    }

    @Nonnull
    @Security.Authenticated(Secured.class)
    private Result handleThriftGet(@Nullable String company, @Nullable String project) {
        ByteString body = request().body().asRaw().asBytes();
        String type = request().header("Content-Type").get();
        if (type.contentEquals("application/x-thrift")) {
            return ok("Done");
        } else {
            return badRequest("Content Not Thrift");
        }
    }

    @Nonnull
    @Security.Authenticated(Secured.class)
    private Result handleThriftPost(@Nullable String company, @Nullable String project) {
        ByteString body = request().body().asRaw().asBytes();
        String type = request().header("Content-Type").get();
        if (type.contentEquals("application/x-thrift")) {
            return ok("Done");
        } else {
            return badRequest("Content Not Thrift");
        }
    }
}

