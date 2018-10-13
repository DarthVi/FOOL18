push 0
push 1
push 2
push function0
push 100
lfp
lfp
push -4
lfp
add
lw
js
halt

function0:
cfp
lra
push -2
lfp
lw
add
lw
push 1000
add
srv
sra
pop
sfp
lrv
lra
js
