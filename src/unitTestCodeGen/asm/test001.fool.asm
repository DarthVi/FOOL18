push 0
push function0
push function1
push function2
push function3
push function4
push function5
push function6
lfp
push 1
push 42
lfp
push -8
lfp
add
lw
js
halt

function0:
cfp
lra
push 0
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
push 1
lfp
add
lw
push 1
add
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
push 1
sub
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
srv
sra
pop
pop
sfp
lrv
lra
js

function4:
cfp
lra
lfp
push 3
lfp
add
lw
lfp
lw
push -4
lfp
lw
add
lw
js
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

function5:
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
lfp
lfp
push 2
lfp
add
lw
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -7
lfp
lw
add
lw
js
push 2
lfp
add
lw
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -6
lfp
lw
add
lw
js
b label1
label0:
lfp
push 2
lfp
add
lw
lfp
lw
push -5
lfp
lw
add
lw
js
label1:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function6:
cfp
lra
lfp
push 2
lfp
add
lw
push 1
lfp
add
lw
lfp
lw
push -7
lfp
lw
add
lw
js
push 0
beq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
lfp
lfp
push 2
lfp
add
lw
lfp
lw
push -3
lfp
lw
add
lw
js
push 1
lfp
add
lw
lfp
lw
push -8
lfp
lw
add
lw
js
b label5
label4:
push 2
lfp
add
lw
label5:
srv
sra
pop
pop
pop
sfp
lrv
lra
js
