package programmerzamannow.mengulang.component;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import programmerzamannow.mengulang.data.Client;

@Component(value = "client")
public class ClientFactoryBean implements FactoryBean<Client> {
    @Override
    public Client getObject() throws Exception {
        var client = new Client();
        client.setName("hyns");
        client.setAddress("kintap");
        client.setAge(18);
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return Client.class;
    }
}
