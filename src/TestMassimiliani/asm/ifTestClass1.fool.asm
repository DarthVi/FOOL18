push 0
push 0
push classA
new
push 0
push classB
new
push 0
push classC
new
push 1
push 1
beq label0
lfp
push -4
lfp
add
lw
copy
lw
push 1
add
lc
js
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
function1
function2
classnull:
