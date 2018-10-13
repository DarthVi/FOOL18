push 0
push 1
push 2
push 3
push function0
lfp
lfp
push -5
lfp
add
lw
js
push 2
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
