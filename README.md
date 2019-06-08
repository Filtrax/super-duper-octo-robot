# Fortran zad2 FFT

-- W programie "signal sum" tworzę gęstą listę wartości funkcji sin(2 ∗ π ∗ t ∗ 200) + 2 ∗ sin(2 ∗ π ∗ t ∗ 400) dla równoodległych punktów. Na jej podstawie w programie Gnuplot utworzyłem taki wyres:
![alt text](https://github.com/Filtrax/super-duper-octo-robot/blob/master/res/1signal.png)

Następnie przeprowadzam transformatę Fouriera za pomocą funkcji z pakietu FFTW.
Biorąc pod uwagę tylko pierwszą połowę wartości (druga jest lustrzanym odbiciem) otrzymuję następujący wykres:
![alt text](https://github.com/Filtrax/super-duper-octo-robot/blob/master/res/1frequency.png)

Na wykresie widzimy wyraźne skoki dla wartości 200 i 400. Są to częstotliwości sygnałów składowych wejściowego sygnału.
Tranformata Fouriera jest więc przydatna gdy chcemy sprawdzić, z jakich częstotliwości składa się dany sygnał.

-- W programie "noise" dla równoodległych punktów w gęstej tablicy znajduję wartości funkcji cosinus z dodatkowo dodaną losową wartością.
W ten sposób otrzymuję poniższy wykres:
![alt text](https://github.com/Filtrax/super-duper-octo-robot/blob/master/res/2noise.png)

By wyodrębnić częstotliwości przeprowadzam na otrzymanych wartościach transformatę Fouriera otrzymając następujący wykres (po odrzuceniu połowy wartości):
![alt text](https://github.com/Filtrax/super-duper-octo-robot/blob/master/res/2frequency.png)

Na wykresie losowy "szum" jest widoczny jako niewielkie wachania wartości w całej dziedzinie.
By się ich pozbyć, wszystkie wartości mniejsze od 50 zamieniam na 0. Otrzymany w ten sposób wykres:
![alt text](https://github.com/Filtrax/super-duper-octo-robot/blob/master/res/2cleaned%20frequency.png)

By zobaczyć wynikowy sygnał po usunięciu szumu, wykonuję odwrotną transformatę Fouriera i zapisuję wartości rzeczywiste wyniku.
Otrzymany w ten sposób wykres:
![alt text](https://github.com/Filtrax/super-duper-octo-robot/blob/master/res/2cleanednoise.png)

Wynikiem jest prawie idealny wykres cosinusa. Transformata Fouriera wraz z odwrotną tranformatą Fouriera jest więc przydatnym narzędziem przy pozbywaniu się szumów np. z nagrań dżwiękowych.
