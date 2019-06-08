all: build execut

build:
	gfortran -o uno signalsum.f90 -Ldirectory -lfftw3
	gfortran -o due noise.f90 -Ldirectory -lfftw3
execut:
	./uno
	./due