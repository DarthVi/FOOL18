push 0
push 12
push function0
push -2
lfp
add
lw
push 1
sub
push -2
lfp
add
sw
push -2
lfp
add
lw
push 2
sub
push -2
lfp
add
sw
push -2
lfp
add
lw
push 3
sub
push -2
lfp
add
sw
push -2
lfp
add
lw
print
halt

function0:
cfp
lra
push -2
lfp
lw
add
lw
push 12
sub
push -2
lfp
lw
add
sw
srv
sra
pop
sfp
lrv
lra
js
