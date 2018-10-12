push 0
push 5
push 2
add
push 12
push 1
push function0
push function1
lfp
lfp
push -6
lfp
add
lw
js
halt

function0:
cfp
lra
push 2
lfp
add
lw
push 1
lfp
add
lw
push 2
lfp
add
lw
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
push 2
lfp
add
lw
bleq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
lfp
push 1
push 1
lfp
lw
push -5
lfp
lw
add
lw
js
b label5
label4:
lfp
push 2
push 3
lfp
lw
push -5
lfp
lw
add
lw
js
label5:
b label1
label0:
push 1
label1:
srv
pop
sra
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
lfp
push 10
push 1
lfp
lw
push -5
lfp
lw
add
lw
js
push -2
lfp
add
lw
srv
pop
sra
pop
sfp
lrv
lra
js
