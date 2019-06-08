program main
    use, intrinsic :: iso_c_binding
    implicit none
    include "fftw3.f03"

    integer, parameter :: n = 1000
    real(kind = 16), parameter :: PI = 3.1415926535897932384626
    real(kind = 8) :: t = 0.0, step = 0.001
    integer :: i
    type(c_ptr) :: plan
    real(c_double), dimension(n) :: input
    complex(c_double_complex), dimension(n/2 +1) :: output

    open(1, file = "../res/time.txt", status = 'replace', action = 'write')
    open(2, file = "../res/frequency.txt", status = 'replace', action = 'write')


    do i = 1, n
        t = t + step
        input(i) = sin(2 * PI * t * 200) + 2 * sin(2 * PI * t * 400)
        write(1, *) t, " ", input(i)
    end do

    plan = fftw_plan_dft_r2c_1d(size(input), input, output, FFTW_ESTIMATE+FFTW_UNALIGNED)
    call fftw_execute_dft_r2c(plan, input, output)

    do i = 1, size(output)
        write(2,*) i, " ", abs(output(i))
    end do

    call fftw_destroy_plan(plan)
    close(1)
    close(2)

end program