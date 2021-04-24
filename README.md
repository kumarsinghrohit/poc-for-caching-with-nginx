# Mosaiq Store PoC for caching with nginx  

## mandatory directives to be defined in nginx.conf
  - proxy_cache_path: Which defines a "caching zone". it must be defined in the http section of nginx. For a more detailed description, take a look at the official documentation of proxy_cache_path(http://nginx.org/en/docs/http/ngx_http_proxy_module.html#proxy_cache_path).
  
  - proxy_cache: It can be defined in the context (protocol type, virtual server, or location) for which you want to cache server responses, specifying the zone name defined by the keys_zone parameter to the proxy_cache_path directive.
  
  - proxy_cache valid: It defines how long upstream responses should be cached.
  
  - X-Proxy-Cache: It is an additional header which is added in the reverse proxie's response to identify, if the served content comes from cache (HIT) or directly from upstream (MISS).
  
  - proxy_pass: defines the address pointing to the application.
  
  
## NOTE: 
  - The "proxy_buffering" directive should be set to "off", which is by default off. But in some cases if we include any other proxy setting configuration via "include" directive, and inside that configuration file if proxy_buffering is set to "on", then in that case the Proxy-Cache status will show "MISS".
  - In Addition to above, we should remove/hide "Set-Cookie" from the header as Nginx caching does not work, if the http response from the upstream server contains the http header "Set-Cookie". It can be done using "proxy_ignore_headers" and "proxy_hide_header" directives.