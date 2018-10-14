push 0
push function0
push function1
push function2
push function3
push 30
lfp
push -6
lfp
add
lw
lfp
push -3
lfp
add
lw
js
lfp
push -6
lfp
add
lw
lfp
push -2
lfp
add
lw
js
lfp
push -6
lfp
add
lw
lfp
push -4
lfp
add
lw
js
lfp
push -6
lfp
add
lw
lfp
push -5
lfp
add
lw
js
add
add
add
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 0
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 1
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -3
lfp
lw
add
lw
js
add
b label1
label0:
push 0
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
lfp
add
lw
push 0
beq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
push 1
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -4
lfp
lw
add
lw
js
add
b label5
label4:
push 0
label5:
srv
sra
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1
lfp
add
lw
push 0
beq label10
push 0
b label11
label10:
push 1
label11:
push 1
beq label8
push 1
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -5
lfp
lw
add
lw
js
add
b label9
label8:
push 0
label9:
srv
sra
pop
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 1
lfp
add
lw
push 0
beq label14
push 0
b label15
label14:
push 1
label15:
push 1
beq label12
push 1
lfp
add
lw
lfp
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -2
lfp
lw
add
lw
js
add
b label13
label12:
push 0
label13:
srv
sra
pop
pop
sfp
lrv
lra
js
