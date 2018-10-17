push 0
push function0
push 1
push 0
beq label0
push 0
b label1
label0:
push 1
push 1
beq label2
push 0
b label1
label2:
push 1
label1:
push 1
push 1
beq label3
push 0
push 1
beq label3
push 0
b label4
label3:
push 1
label4:
lfp
push 10
push 4
sub
push 2
div
push -3
lfp
add
lw
push 1
beq label7
push -4
lfp
add
lw
push 1
beq label7
push 0
b label8
label7:
push 1
label8:
push 1
beq label5
push 5
b label6
label5:
push 10
label6:
lfp
push -2
lfp
add
lw
js
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js
