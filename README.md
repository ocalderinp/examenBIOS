La empresa de e-commerece NopCommerce se encuentra
en un proceso de actualización de su plataforma de ventas, el
cual implica cambios a nivel de backend y base de datos.
Según el equipo de desarrollo, estos cambios no afectan la
capa de presentación, por lo cual surge la idea de realizar
pruebas automáticas a nivel de la interfaz web de la empresa,
para verificar el correcto funcionamiento de la misma luego de
la implementación de los cambios.

Par poder realizar las pruebas correspondientes, se cuenta
con un ambiente de Testing, el cual puede ser accedido con
la siguiente URL http://demo.nopcommerce.com/ y con un framework 
de automatización desarrollado por la empresa utilizando Selenium y TestNG
el cual deberá ser utilizado para desarrollar los casos de pruebas, 
por lo que será necesario dedicar un tiempo al incio para entender lo que está desarrollado
y seguir estas pautas.

En esta primera fase se deberán automatizar 2 casos de prueba distintos:

**CP1: Buscar Producto:**
1. Realizar la búsqueda de al menos 3 productos.
2. Validar que el producto buscado aparece en los resultado de la búsqueda.

**CP2: Agregar a Wish List:**
1. Realizar una búsqueda que arroje más de un resultado.
2. Agregar dos productos a la Wish List.
3. Ir a “Whishlist”.
4. Validar que los productos fueron agregados
correctamente.

**Notas**

● Todos los casos deben tener un mínimo de 3
validaciones/assertions. Se valorará que las validaciones
realizadas en cada caso de prueba sean apropiadas
(verifiquen aspectos relevantes).

● Para aplicar Data Driven Testing se debe utilizar Data
Providers (TestNG).

● No deben existir selectores absolutos, ya sean Xpath o
CSS.

● Las pruebas deben poder ejecutarse en chrome y firefox.

● También se deberá proveer un reporte que muestre los resultados
  de la ejecución de estas pruebas, utilizando la herramiente para
  reportes que trae el framework (Extent Report).







