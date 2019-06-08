program main
    use, intrinsic :: iso_c_binding
    implicit none
    include "fftw3.f03"

    integer, parameter :: n = 1000
    real(kind = 16), parameter :: PI = 3.1415926535897932384626
    real(kind = 8) :: t = 0.0, step = 0.001
    integer :: i
    type(c_ptr) :: plan1, plan2
    real(c_double), dimension(n) :: input
    complex(c_double_complex), dimension(n/2 +1) :: output
    integer,parameter :: seed = 35354
    
    call srand(seed)

    open(1, file = "../res/noise.txt", status = 'replace', action = 'write')
    open(2, file = "../res/noisefrequency.txt", status = 'replace', action = 'write')
    open(3, file = "../res/cleanednoisefrequency.txt", status = 'replace', action = 'write')
    open(4, file = "../res/cleanednoise.txt", status = 'replace', action = 'write')


    do i = 1, n
        t = t + step
        input(i) = cos(2 * PI * t * 2) + ( 0.5 - rand() )*0.2
        write(1, *) t, " ", input(i)
    end do

    plan1 = fftw_plan_dft_r2c_1d( size(input), input, output, FFTW_ESTIMATE+FFTW_UNALIGNED)
    call fftw_execute_dft_r2c(plan1, input, output)

    do i = 1, size(output)
        write(2, *) i," ",  abs(output(i))
        if( abs(output(i)) < 50) output(i) = 0.0
        write(3, *) i," ",  abs(output(i))
    end do

    plan2 = fftw_plan_dft_c2r_1d( size(input), output, input, FFTW_ESTIMATE+FFTW_UNALIGNED)
    call fftw_execute_dft_c2r(plan2, output, input)

    t = 0.0
    do i = 1, n
        t = t + step
        write(4, *) t, " ", input(i) / n
    end do

    call fftw_destroy_plan(plan1)
    call fftw_destroy_plan(plan2)
    close(1)
    close(2)
    close(3)
    close(4)

end program