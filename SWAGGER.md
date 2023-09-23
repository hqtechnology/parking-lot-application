## Swagger Set Up

###### Documentation followed
- [springdoc.org](https://springdoc.org/)
- [migrating-from-springfox](https://springdoc.org/#migrating-from-springfox)

### Add the below dependencies in your spring boot application.
```groovy
    implementation group: 'org.springdoc', name: 'springdoc-openapi-starter-webflux-ui', version: '2.2.0'
    implementation group: 'org.springdoc', name: 'springdoc-openapi-starter-webmvc-api', version: '2.2.0'
    implementation group: 'org.springdoc', name: 'springdoc-openapi-starter-webmvc-ui', version: '2.2.0'
```
### Add below configuration in your [application.yaml](/service/src/main/resources/application.yml)
```yaml
springdoc:
  use-management-port: false
  show-actuator: true
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui
```
###### Open swagger at [swagger link](http://localhost:8080/swagger-ui/index.html#/)
