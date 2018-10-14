push 0
push 5
push 0
push classric
new
lfp
push 5
push -3
lfp
add
lw
copy
lw
push 0
add
lc
js
halt

function0:
cfp
lra
push 1
lfp
add
lw
push -2
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
push -2
lfp
add
lw
lfp
push -2
lfp
add
lw
push 1
sub
push 0
lfp
add
lw
copy
lw
push 0
add
lc
js
mult
b label1
label0:
push 1
label1:
srv
pop
sra
pop
pop
sfp
lrv
lra
js
classric:
function0
classnull:
