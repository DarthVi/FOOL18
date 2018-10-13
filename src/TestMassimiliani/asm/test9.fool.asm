push 0
push 1
push 0
push -2
lfp
add
lw
push -3
lfp
add
lw
beq label2
push 0
b label3
label2:
push -2
lfp
add
lw
push 1
beq label4
push 0
b label3
label4:
push 1
label3:
push 1
beq label0
push -3
lfp
add
lw
push 1
beq label5
push -2
lfp
add
lw
push 1
beq label9
push -3
lfp
add
lw
push 1
beq label9
push 0
b label10
label9:
push 1
label10:
push 1
beq label7
push 4
b label8
label7:
push 3
label8:
b label6
label5:
push 2
label6:
b label1
label0:
push 1
label1:
halt
