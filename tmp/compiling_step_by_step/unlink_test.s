	.file	"unlink_test.c"
	.section	.rodata
.LC0:
	.string	"/tmp/test"
.LC1:
	.string	"Hello world\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movl	$448, %esi
	leaq	.LC0(%rip), %rdi
	call	creat@PLT
	movl	%eax, -4(%rbp)
	leaq	.LC0(%rip), %rdi
	call	unlink@PLT
	movl	-4(%rbp), %eax
	movl	$12, %edx
	leaq	.LC1(%rip), %rsi
	movl	%eax, %edi
	call	write@PLT
	movl	-4(%rbp), %eax
	movl	%eax, %edi
	call	close@PLT
	movl	$0, %eax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (GNU) 7.2.0"
	.section	.note.GNU-stack,"",@progbits
