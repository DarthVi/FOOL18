push 0
push 0
push 3
push 2
push function0
push function1
push function2
push 1
push function3
push function4
push function5
push function6
push function7
lfp
push 5
lfp
push -10
lfp
add
lw
js
halt

function0:
cfp
lra
push 2
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
push 3
lfp
add
lw
push -2
lfp
add
lw
push -3
lfp
add
lw
push -4
lfp
add
lw
add
add
srv
pop
pop
pop
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
push 2
push 2
lfp
add
lw
mult
push 2
lfp
add
lw
push 2
div
push 1
lfp
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
push -3
lfp
add
lw
b label1
label0:
push -2
lfp
add
lw
label1:
srv
pop
pop
sra
pop
pop
pop
sfp
lrv
lra
js

function4:
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
push -11
lfp
lw
add
lw
js
mult
b label5
label4:
push 1
label5:
srv
sra
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
push -10
lfp
lw
add
lw
js
mult
b label9
label8:
push 1
label9:
srv
sra
pop
pop
sfp
lrv
lra
js

function6:
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
push -12
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

function7:
cfp
lra
push -4
lfp
lw
add
lw
push 0
beq label18
push 0
b label19
label18:
push 1
label19:
push 1
beq label16
push -4
lfp
lw
add
lw
lfp
push -4
lfp
lw
add
lw
push 1
sub
lfp
lw
push -12
lfp
lw
add
lw
js
add
b label17
label16:
push 0
label17:
srv
sra
pop
pop
sfp
lrv
lra
js
