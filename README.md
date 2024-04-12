# GraRewolwerowiec
# Temat 
Gra dla dwóch graczy polegająca na wykazaniu się refleksem. Gracze czekają na komendę strzał ten kto strzeli pierwszy wygrywa. W przypadku oddania strzału przed komendą punkt zdobywa przeciwnik.
# Endpointy 
GET / : wejście na stronę startową gry
POST /start/{imie}: przekazanie swojego imienia i dołączenie do gry
POST /game/shoot/{player}/{shootTime}: przekazanie informacji, który gracz strzelił oraz czy strzelił przed komendą czy po komendzie


