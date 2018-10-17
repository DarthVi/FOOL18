push 0
push function1
lfp
push 1
lfp
push -2
lfp
add
lw
js
push -1
push classnull
new
beq label4
push 0
b label5
label4:
push 1
label5:
push 1
beq label2
push 40
b label3
label2:
push 10
label3:
print
lfp
push 0
lfp
push -2
lfp
add
lw
js
push -1
push classnull
new
beq label8
push 0
b label9
label8:
push 1
label9:
push 1
beq label6
push 40
b label7
label6:
push 10
label7:
print
halt

function0:
cfp
lra
push 4
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
beq label0
push 0
push classpippo
new
b label1
label0:
push -1
push classnull
new
label1:
srv
sra
pop
pop
sfp
lrv
lra
js
classpippo:
function0
classnull:
