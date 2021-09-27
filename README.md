<h1 align="center">Prueba Inditex </h1>

## Autor
👤 **JuanCBM**: Juan Carlos Blázquez Muñoz

* Github: [@JuanCBM](https://github.com/JuanCBM)


----------------------


## Ejecución:
Se pueden ejecutar los test con el comando.
> `mvn test`

----------------------

## Interpretaciones:
- Se devuelve el id de la tarifa a aplicar.
- Si el desambiguador no soluciona el problema de encontrar varios resultados, se utiliza la fecha de creación y posteriormente el id.

----------------------

## Sobre la aplicación:
- Se han obtenido los datos del enunciado para generar un csv que posteriormente se carga en la aplicación.

- Para no interferir en la BBDD utilizada en la aplicación, en desarrollo o en cualquier entorno, se ha utilizado un Profile de "test" que configura una nueva BBDD. Además, la carga de datos en dicha BBDD sólo se realiza con el perfil comentado activado.

- Se facilita un swagger para poder realizar peticiones a la aplicación en caso de ser necesario y su documentación.
> http://localhost:8080/swagger-ui/

- Se utilizan proyecciones para la respuesta de la consulta realizada como query nativa.

- Se facilita una consola de acceso a la BBDD.
> http://localhost:8080/h2-console

- Se facilita un dockerfile para el despliegue de la aplicación y la ejecución de test.

> ``docker build -t e-commerce:v1 .``

> ``docker run --name e-commerce -p 8080:8080 e-commerce:v1``