push 0
push 10
push 2
push function0
lfp
lfp
push -4
lfp
add
lw
js
lfp
lfp
push -4
lfp
add
lw
js
lfp
lfp
push -4
lfp
add
lw
js
add
add
push -2
lfp
add
sw
halt

function0:
cfp
lra
push -2
lfp
lw
add
lw
push 1
sub
srv
sra
pop
sfp
lrv
lra
js
