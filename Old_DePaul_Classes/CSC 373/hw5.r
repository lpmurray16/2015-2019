f1:
	subl	$97, %edi
	xorl	%eax, %eax
	cmpb	$25, %dil
	setbe	%al
	ret

*****C code f1**********
int f1(char f){
	f-=97;
	int x = 0;
	if(f <= 25)
		x = 1;
	return x;
}
********************
	
f2:
	cmpl	%edx, %edi
	sete	%dl
	xorl	%eax, %eax
	cmpl	%esi, %edi
	sete	%al
	andl	%edx, %eax
	ret
	
*****C code f2**********
int f2(int x, int y, int z){
	if(x > z)
		int a = 0;
	if(x > y)
		a = 1;
}	
	
*************************
f3:
	movq	%rdi, %rax   // rax = rdi
	notq	%rax         // ~rax
	shrq	$63, %rax    // rax >> 63
	ret

*****C code f3************
long f3(long x){
	return 
}
**************************
	
f4:
	cmpl	$1, %edi
	jle	.L9
	addl	$1, %edi
	movl	$2, %edx
	movl	$1, %eax
.L8:
	imull	%edx, %eax
	addl	$1, %edx
	cmpl	%edi, %edx
	jne	.L8
	ret
.L9:
	movl	$1, %eax
	ret

f5:
	cmpl	$1, %esi
	jle	.L28
	movl	4(%rdi), %eax
	cmpl	%eax, (%rdi)
	jg	.L30
	addq	$4, %rdi
	subl	$1, %esi
	xorl	%eax, %eax
	jmp	.L26
.L27:
	movl	(%rdi), %edx
	addq	$4, %rdi
	cmpl	(%rdi), %edx
	jg	.L30
.L26:
	addl	$1, %eax
	cmpl	%esi, %eax
	jne	.L27
.L28:
	movl	$1, %eax
	ret
.L30:
	xorl	%eax, %eax
	ret
