# QRCode-Generator-Spring-Boot
This is a simple QRCodeGenerator application built using Spring Boot.
It is using Zxing Library to generate the QR Codes.
<br/>
# How to run
<ul>
<li>First Clone the repository</li>
<li>Open the project in your favourite Id. The dependencies will be installed automatically by your IDE</li>
<li>Go to application.yml file in your resource folder and change the database connections to suite yours</li>
<li>POST different products to your db using this endpoint: http://localhost:8080/api/v1/products?name=YOURPRODUCTNAME&cost=YOURPRODUCTCOST</li>
<li>GET all products using endpoint: http://localhost:8080/api/v1/products</li>
<li>When the geAllProduct method is called the QR Codes are generated and stored in the QRCodes folder in the root directory</li>
</ul>
