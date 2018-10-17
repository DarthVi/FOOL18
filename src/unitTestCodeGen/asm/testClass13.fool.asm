push 0
push 11
push 1
push classA
new
push 1
push classB
new
push 1
push classC
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
halt

function0:
cfp
lra
push 10
push 1
push 0
lfp
add
lw
calchoff
add
lw
add
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
lfp
push 1
lfp
lw
add
lw
copy
lw
push 0
add
lc
js
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
lfp
push 1
lfp
lw
add
lw
copy
lw
push 0
add
lc
js
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
