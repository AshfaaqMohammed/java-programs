package com.Networking.HTTP;

import java.net.URI;

public class URIBasics {
    public static void main(String[] args) {
        URI ashSite = URI.create("https://mtgph-test.dma-dev-regency.infor.com:443/metagraph/api/v1/ping");
        print(ashSite);
    }
    private static void print(URI uri){
        System.out.printf("""
                ----------------------------------------------
                [scheme:]scheme-specific-part[#fragment]
                ----------------------------------------------
                Scheme: %s
                Scheme-specific part: %s
                  Authority: %s
                    User info: %s
                    Host: %s
                    Port: %d
                    path: %s
                    Query: %s
                Fragment: %s
                """,uri.getScheme(),
                uri.getSchemeSpecificPart(),
                uri.getAuthority(),
                uri.getUserInfo(),
                uri.getHost(),
                uri.getPort(),
                uri.getPath(),
                uri.getQuery(),
                uri.getFragment());
    }
}
