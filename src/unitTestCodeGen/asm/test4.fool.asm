push 0
push 1
push 2
push 3
push function0
push 12
push function1
push function2
lfp
lfp
push -7
lfp
add
lw
js
push -6
lfp
add
lw
lfp
lfp
push -5
lfp
add
lw
js
lfp
push 2
lfp
push -8
lfp
add
lw
js
add
add
add
halt

function0:
cfp
lra
push 12
push -2
lfp
add
lw
push -3
lfp
lw
add
lw
add
srv
pop
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 12
push -2
lfp
lw
add
lw
push -2
lfp
add
lw
add
srv
pop
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 12
push 1
lfp
add
lw
push 1
add
srv
pop
sra
pop
pop
sfp
lrv
lra
js
