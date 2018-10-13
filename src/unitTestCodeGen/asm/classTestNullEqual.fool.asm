push 0
push -1
push classpippo
new
push 0
push classclarabella
new
push -2
lfp
add
lw
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
push 20
b label3
label2:
push 10
label3:
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 1
beq label0
push 5
b label1
label0:
push 3
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
push 4
srv
sra
pop
sfp
lrv
lra
js
classpippo:
function0
classclarabella:
function1
classnull:
