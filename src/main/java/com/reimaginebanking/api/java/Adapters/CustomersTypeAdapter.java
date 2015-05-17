package com.reimaginebanking.api.java.Adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.reimaginebanking.api.java.Models.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxp347 on 5/8/15.
 */
public class CustomersTypeAdapter extends TypeAdapter<List<Customer>> {
    @Override
    public void write(JsonWriter out, List<Customer> value) throws IOException {

    }

    @Override
    public List<Customer> read(JsonReader in) throws IOException {
        List<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();

        in.beginArray();
        while(in.hasNext()){
            switch(in.nextName()){
                case "{":
                    in.beginObject();
                    customer = new Customer();
                    break;
                case "}":
                    in.endObject();
                    break;
                case "_id":

                    break;
                case "transaction_date":
                    break;
                case "status":
                    break;
                case "type":
                    break;
                case "medium":
                    break;
                case "payer_id":
                    break;
                case "payee_id":
                    break;
                case "amount":
                    break;
                case "description":
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }

        in.endArray();


        return null;
    }
}
