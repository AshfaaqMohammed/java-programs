package com.Networking.websockets;

public class notes {
    /*
    In HTTP communication -
        - it is one-directional
        - means - client made a request to a server and the server optionally responded.
        - server will not send any request or ping to client
    In websockets communication -
        - A websocket creates a persistent connection between the server and client, which can be used to send message back and forth
        - this means server knows who its clients are and can reach out to client.

        - websockets leverage the reliability of tcp connections,
        - but wont completely relay on http but establish a connection using HTTP handshake.

        - websockets require a special handshake when a connection is established.
        - they uses a specific message format
        - they uses something called a binary framing format, text needs to be encoded before
          sending and decoded on the receiving end.
     */
}
