auth-proxy
===

Demo, how to use an nginx / openresty to act as an OpenID Connect proxy to protect web applications.

In the demo https://github.com/zmartzone/lua-resty-openidc is used as a proxy and a custom Spring Boot application acts as a relying party. The Spring Boot application extracts the principal from the _Access Token_.


Build
---

```
echo "127.0.0.1       keycloak"  | sudo tee -a /etc/hosts
cd spring-resource-server/ ; ./mvnw clean package ; cd ..
docker-compose up --build -d
```

The entry in the /etc/hosts file is required on a local machine, as keycloak is available in docker on another host other than from the local browser.
If you find a better way, a pull request is highly appreciated.

Keycloak
---

Admin-UI: http://localhost/auth/admin/master/console/

| Username      | Password      |
| ------------- | ------------- |
| admin         | admin         |

A realm _myapp_ is created with `import-realm.json`.

Now, Feel free to add users in the realm:

http://localhost/auth/admin/master/console/#/realms/myapp/users



lua-resty-openidc
---

This is the acutal auth-proxy.
A nginx container, based on openresty and the lua-resty-openidc plugin, is configured to use Keycloak as an Identity Provider.

See nginx.conf for details.


Spring Resource Server
---

A Spring Boot application is started on:

http://localhost/app1

On the first access, the browser is redirected to the Keycloak's login screen.
With a correct login, the browser is redirected back to the application, which extracts the principal from the access token.

Disclaimer
---

This is a functional demo only. 
Do not use this in production.

You need to think about high availability, network configuration, and much more.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.