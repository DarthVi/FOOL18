push 0
push 1
push 2
push 1
push 0
push function0
push function1
push function2
push function3
lfp
lfp
push -6
lfp
add
lw
js
lfp
lfp
push -7
lfp
add
lw
js
lfp
push 20
push -4
lfp
add
lw
push 1
lfp
push -8
lfp
add
lw
js
lfp
push 10
push -5
lfp
add
lw
push -5
lfp
add
lw
lfp
push -9
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
push -4
lfp
lw
add
lw
push 1
beq label2
push -5
lfp
lw
add
lw
push 1
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 4
b label1
label0:
push 3
label1:
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push -4
lfp
lw
add
lw
push -5
lfp
lw
add
lw
beq label6
push 0
b label7
label6:
push -4
lfp
lw
add
lw
push 1
beq label8
push 0
b label7
label8:
push 1
label7:
push 1
beq label4
push 5
b label5
label4:
push 3
label5:
srv
sra
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
push 2
lfp
add
lw
beq label11
push 0
b label12
label11:
push 1
lfp
add
lw
push 1
beq label13
push 0
b label12
label13:
push 1
label12:
push 1
beq label9
push 3
lfp
add
lw
push 2
div
b label10
label9:
push 3
lfp
add
lw
push 2
mult
label10:
srv
sra
pop
pop
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
push 1
beq label16
push 2
lfp
add
lw
push 1
beq label16
push 0
b label17
label16:
push 1
label17:
push 1
beq label14
push 3
lfp
add
lw
push 2
div
b label15
label14:
push 3
lfp
add
lw
push 2
mult
label15:
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js
