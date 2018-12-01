import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

import java.io.IOException;

public class RPCserver implements Bizable{

    public String sayHi(String name) {
        return "HI! " + name;
    }

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        Server server =  new RPC.Builder(conf).setProtocol(Bizable.class).setInstance(new RPCserver()).setBindAddress("192.168.1.107").setPort(9527).build();
        server.start();




    }
}
