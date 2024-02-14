package com.example;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class MyClient {
    public static void main(String[] args) {
        try {
            // Create the RPCServiceClient
            RPCServiceClient client = new RPCServiceClient();

            // Set the endpoint URL
            EndpointReference endpoint = new EndpointReference("http://www.dneonline.com/calculator.asmx");
            Options options = client.getOptions();
            options.setTo(endpoint);

            // Add operation parameters
            Object[] params;

            // Execute Add operation
            params = new Object[]{2, 1};
            Object[] addResult = client.invokeBlocking("Add", params);
            int addResponse = Integer.parseInt(addResult[0].toString());
            System.out.println("AddResponse: " + addResponse);

            // Execute Divide operation
            params = new Object[]{2, 2};
            Object[] divideResult = client.invokeBlocking("Divide", params);
            int divideResponse = Integer.parseInt(divideResult[0].toString());
            System.out.println("DivideResponse: " + divideResponse);

            // Execute Multiply operation
            params = new Object[]{2, 2};
            Object[] multiplyResult = client.invokeBlocking("Multiply", params);
            int multiplyResponse = Integer.parseInt(multiplyResult[0].toString());
            System.out.println("MultiplyResponse: " + multiplyResponse);

            // Execute Subtract operation
            params = new Object[]{2, 1};
            Object[] subtractResult = client.invokeBlocking("Subtract", params);
            int subtractResponse = Integer.parseInt(subtractResult[0].toString());
            System.out.println("SubtractResponse: " + subtractResponse);

        } catch (AxisFault e) {
            e.printStackTrace();
        }
    }
}
