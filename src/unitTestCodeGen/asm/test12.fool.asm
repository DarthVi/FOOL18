push 0
push 12
push function0
push -2
lfp
add
lw
push 1000
add
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
