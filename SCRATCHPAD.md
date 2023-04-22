
DODANIE ZALEŻNOŚCI BAZY DANYCH
- baza danych "in memory" czyli h2
- JPA

W application properties odpalenie bazy h2
- trzeba wpisać spring.h2.console.enabled=true

Teraz można odpalić w przeglądarce odpowiedniego url
localhost:8080/h2-console


DODANIE STRUKTURY BAZY DANYCH (wprowadzenie własnej struktury)
- tworzymy plik schema.sql w folderze resources

DODANIE PLIKU Z DANYMI DO BAZY DANYCH

Utworzenie pakietu config z cklasą konfiguracyjną. Adnotacja @configuration
Wrzucenie tam ObjectMappera


Service - można ustawić scope dla niego

INSTALOWANIE SWAGGERA
- dodanie zależności ze strony mvnrepository.com -> springfox Swagger
- dodanie w konfiguracji adnotacją EnableSwagger2
- w przeglądarce wpisujemy localhost:8080/swager-ui

DODAJEMY W APPLICATION PROPERTIES zapis, hibernate nie tworzył nowej tabeli

