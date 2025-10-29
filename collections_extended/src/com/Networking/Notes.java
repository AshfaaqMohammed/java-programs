package com.Networking;

public class Notes {
    // No code only Notes are written in this class.


    /*
        Networking  - it is the foundation of modern communication.
                    - It is a system of computers and other devices connected together, so that they communicate with each other, to exchange data and share resources.
                    - networking can be done over the internet, or over a local area network.

        Important terms -
            1. Private Network (intranet) - computers may also communicate across a private network called as intranet.
            2. Host - host refers to any hardware device capable of participating in network communication
            3. clients - clients are end-user devices or applications, that request services or resources from servers.
            4. Server - these are usually powerful computers or software applications, that provide services or resources to clients.
            5. client-server model - Communication between the users devices and servers responding to their requests is called the client-server model.

        IPv4 vs IPv6
            - IPv4 stands for internet protocol version 4
            - it uses a 32-bit address scheme, that allows for over 4billion addresses.

            - IPv6 uses a 128-bit address scheme, which allows for many more ip addresses than IPv4


        How do the client and server communicate?

            1. data transfer layer provides different protocols for transferring data.
            2. TCP(transmission control protocol) and UDP (user datagram protocol) - these two protocols are widely used by client server applications

            Feature                     TCP                                 UDP
            1. Connection type        Connection-oriented               Connectionless
            2. Reliability            Highly reliable                   unreliable
            3. category               Stream of data                    Datagram(data packet)
            4. error checking         yes                               NO
            5. overhead               Higher                            Lower
            6. speed                  slower                            faster
            7. use cases              web browsing, email etc           Online gaming, streaming media, real-time data feeds.



        TCP/IP
            1. TCP IP describes both the networking and data transport layers used.
            2. it refers to using the TCP protocol for transferring data, over a network of IP address.


        Networking packages in java -
            1. java.net
                i) Low level Networking APIs
                    a)Socket
                    b)ServerSocket
                    c)DatagramSocket
                    d)InetAddress
                ii) High level (older) networking apis
                    a) URL
                    b)URI
                    c)URLConnection
                    d)HttpURLConnection

            2. java.nio.channels
                i) Non Blocking IO(Includes Network IO channesl
                    a)ServerSocketChannel
                    b)SocketChannel
                    c)DatagramChannel

            3. java.nio.http
                i) High Level (newer-JDK 11) networking apis
                    a)HttpClient
                    b)WebSocket


        Sockets -
            - When using the low level networking api, we will use sockets to establish connections and send requests and receive responses.
            - A socket is the end point of the two-way connection.
            - The client will have a socket and the server will also have a socket
            - when you have multiple clients connecting to the same server, they will use the same port but each client will have its own socket.
            - we will use Socket class fot client socket and ServerSocket class for the server socket.
     */
}
