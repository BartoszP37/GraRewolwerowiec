# GraRewolwerowiec
# Temat 
GRA REWOLWEROWIEC DLA DWÓCH GRACZY
# OPIS
Gra dla dwóch graczy polegająca na wykazaniu się refleksem. Gracze czekają na komendę strzał ten kto strzeli pierwszy wygrywa. W przypadku oddania strzału przed komendą punkt zdobywa przeciwnik.
# Endpointy 
`GET /` : wejście na stronę startową gry

`POST /start/{imie}`: przekazanie swojego imienia i dołączenie do gry

`POST /game/shoot/{player}/{shootTime}`: przekazanie informacji, który gracz strzelił oraz czy strzelił przed komendą czy po komendzie
# Technologia
Jeżyk programowania Java oraz freamwork SpringBoot do sprawnej obsługi działania aplikacji oraz bazy danych. HTML, CSS oraz JavaScript są odpowiedzialne za UI oraz komunikację z użytkownikiem końcowym. Java analizuje informacje w bacnendzie i odsyła do frontendu wyniki działań. 
