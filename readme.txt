Tegemist on Maveni projektiga. Arendatud Eclipsis.

Koodi Eclipsi saamiseks importida olemasoleva Maven projektina.
Ise kasutasin Java 1.8'at ja Tomcat 8'at.
Raamistikuna kasutasin Spring 4'ja ning confi tegin XML'is (uuemad Springid soodustavad ka annotatsioonidega konfi - kunagi korra tegin).

Hibernatet ei kasutanud, kuna lihte andmemudel. Kasutasin JdbcTemplet'it ning baasi lisatakse üks tabel sql skriptiga. Kasutab H2 mälus asuvat baasi, et ei tekitaks palju kõrvalisi faile.

Kursside andmed salvestatakse baasi ning ei minda uuesti pärima (baas on algselt seadistatud küll mälus). Indekseid ja constrainte ei lisanud (antud rakendus ei ela kaua).

Kursside pärimiseks on võimalik lisada allikaid konfi faili kaudu (classpathis resources -> valuuta_allikad.csv). Samas tuleb kirjutada ka vastava tüübiga XML'i jaoks handleri/parsimise klass.

Kasutajaliideses kasutatud veidi jQuery vahendeid. Idee oli ka lehe sisu värskendada AJAX-päringuid kasutades(sujuvam ning vähem ressurssi nõudev, kuna siis ainult teksti kujul või JSON-formaadis vajalike andmete liigutamine ja kogu leht jääks renderdamata), aga hetkel jäi lihtsustatud versioon kogu lehe värskendamisega (kotrolleris ainult üks meetod). Valuutade nimekirja hoitakse kontrolleris sessiooni objektis.

Tegin meelega "käsitööd" ning sisendandmete kontroll jäi kasutajaliidese poole. Järgmises versioonis kasutaksin näiteks commandobjekte ja/või Spring'i (Bean'i põhist)valideerimist(vareme olen teinud annotatisioonidega). Sellise valiku tegin hetkel seoses kasutajaliidese poolse koodiga(tahtsin nii). Kui Spring'i vahendid ei rahulda, siis tuleb teha käsitsi - või kui tahetakse uut moodi proovida. Seekord proovisin jQuery validaatori pluginat(polegi eriti käsitöö). See tundub olevat päris tõhus ja kergelt rakendatav, laiendatav. Tegemist on siiski hetkel tavalise GET-päringuga ning kasutajaliidesest on võimalik serveri poolelt saata midaiganes (ei ole eriti mõistlik).

XML parsimisel kasutatud SAX-parserit (eventitie põhist). Õiges rakenduses peaks tegema xsd pealt klassid jne.. xsd alusel saaks siis ka xml'i valideerida.

Teste ei kirjutanud kuna polnud skoobis. Alustanud oleks servis klassi unit testidega. Veatöötlust ja logimist lisatud minimaalselt. Kood on eesti ja inglise segakeeles ning kommentaarid on vabas vormis.

