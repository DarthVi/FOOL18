push 0
push function0
push function1
push function2
lfp
lfp
push 5
lfp
push -4
lfp
add
lw
js
lfp
lfp
push -3
lfp
add
lw
js
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

function1:
cfp
lra
push 4
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

function2:
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
push -4
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
