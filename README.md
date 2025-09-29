**🐾 Dyrehjemsnettverket Poter og Nebb**

Eksamensoppgåve i faget PGR112 – Programmering 2 (kont-eksamen våren 2025).
Prosjektet er eit Java-program som les data frå tekstfil, lagrar informasjon om dyreheimar og dyr i ein MySQL-database, og gir moglegheit for å hente ut og vise ulike data.

**Funksjonalitet**

📂 Lesing av tekstfil: Parser informasjon om dyreheimar og dyr frå ei tekstfil.

🗄️ Lagring i MySQL: Opprettar databasar og tabellar og legg til data.

🔒 Innkapsling: Alle dataklassar (DTO-ar) brukar private felt med getters/setters.

🧬 Arv og polymorfi:

Abstrakt superklasse Animals for felles eigenskapar.

Polymorfisme via toString() som blir overstyrt i underklassar.

🔍 Spørringar (DAO):

List ut alle dyr

List ut alle dyreheimar

List ut alle kattar som er både vaksinerte og kastrerte

**📝 Rapport:** Kort refleksjon rundt innkapsling, arv/polymorfi og utfordringar undervegs.

**📂 Struktur**
src/
├── dto/                # Data Transfer Objects (Animals, Dog, Cat, Bird, Shelter)
├── dao/                # Data Access Objects (SQL-handsaming)
├── main1.java          # Lesing frå fil og lagring i database
├── main2.java          # Ulike spørringar (list dyr, shelters osv.)
└── resources/          # Tekstfil med input-data

**⚙️ Teknologi**

Java 17

MySQL

IntelliJ IDEA

**🚀 Køyre prosjektet**

Klon repoet:

git clone https://github.com/ditt-brukarnamn/dyrehjemsnettverket.git


Importer prosjektet i IntelliJ eller en anna IDEA som kan kjøre Java.

Sett opp MySQL-database med riktige brukarnamn/passord (sjå DBConnector).

Kjør main1 for å lese og lagre data i databasen.

Kjør main2 for å utføre spørringar.
