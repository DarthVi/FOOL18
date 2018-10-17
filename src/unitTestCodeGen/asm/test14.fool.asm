push 0
push function0
push function1
lfp
push 2
push 4
push 2
lfp
push -3
lfp
add
lw
js
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 2
mult
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
lfp
push 1
lfp
add
lw
lfp
lw
push -2
lfp
lw
add
lw
js
lfp
push 2
lfp
add
lw
lfp
lw
push -2
lfp
lw
add
lw
js
sub
lfp
push 3
lfp
add
lw
lfp
lw
push -2
lfp
lw
add
lw
js
add
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js
