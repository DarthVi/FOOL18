push 0
push 0
push classA
new
push -1
push classA
new
push -3
lfp
add
lw
push -1
push classnull
new
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 666
b label1
label0:
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
label1:
halt

function0:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
classnull:
