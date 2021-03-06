/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.transport.mqtt;

import java.io.IOException;
import java.security.cert.X509Certificate;

import org.apache.activemq.command.Command;
import org.fusesource.mqtt.codec.MQTTFrame;

/**
 * Basic interface that mediates between protocol converter and transport
 */
public interface MQTTTransport {

    public void sendToActiveMQ(Command command);

    public void sendToMQTT(MQTTFrame command) throws IOException;

    public X509Certificate[] getPeerCertificates();

    public void onException(IOException error);

    public MQTTInactivityMonitor getInactivityMonitor();

    public MQTTWireFormat getWireFormat();

    public void stop() throws Exception;
}
