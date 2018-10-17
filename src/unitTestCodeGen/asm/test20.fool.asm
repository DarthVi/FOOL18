push 0
push 0
push classA
new
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
push 1
beq label0
push 666
b label1
label0:
push 0
lfp
push -2
lfp
add
lw
copy
lw
push 2
add
lc
js
sub
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
push 0
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
push -5
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
function1
function2
classnull:
