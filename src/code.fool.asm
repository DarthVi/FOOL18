push 0
push 0
push classB
new
push 0
push classC
new
push 1
push 1
beq label0
push -2
lfp
add
lw
b label1
label0:
push -3
lfp
add
lw
label1:
lfp
push -4
lfp
add
lw
copy
lw
push 0
add
lc
js
print
halt

function0:
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

function1:
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

function2:
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
classB:
function1
classC:
function2
classnull:
